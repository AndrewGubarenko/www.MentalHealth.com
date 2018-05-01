import React from 'react';
import UserData from './../components/UserData';
import {formatDateUtils, imageUploader, visitorService} from './../appContext/Context';
import UserHeader from './../components/UserHeader';
import {connect} from 'react-redux';

//===========Comments================
import {setCommentById} from './../store/server/comment/CommentActions';
import {commentByIdStateType} from './../store/server/comment/CommentReducer';
import CommentTreeContainer from './../containers/CommentTreeContainer';
//===========Comments================

class UserDataContainer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      surname: "",
      speciality: "",
      location: "",
      userPhoto: "",
      essay: "",
      price: "",
      currency: "",
      experience: "",
      birthday: "",
      phoneNumber: "",
      email: "",
      linkedin: "",
      facebook: "",
      skype: "",
      university: "",
      userDiploma: ""
    };
  }

  componentDidMount() {

    let userDataArray = visitorService.getFullProfile(this.props.id).then((data) => {
      return data.json();
    });

    let userData = userDataArray.then(dataList => {
      return dataList[0];
    });

    let userCommentList = userDataArray.then(dataList => {
      return dataList[1];
    });

    userCommentList.then(commentList => {
      let _rating = 0;
      let counter = 0;
      commentList.forEach(comment => {
        if(comment.parentId == null) {
          _rating = _rating + comment.rating;
        counter += 1;
        }
      });
      _rating = _rating/counter;
      return _rating;
    }).then(value => {
      let fullStarsNumber = value | 0;
  		let remainderStar = Math.round((value - fullStarsNumber)*100)/100;
  		for (let i = 0; i < fullStarsNumber; i++) {
  			let name = "currentStar" + i;
  			document.getElementById(name).style.width = '100%';
  		}
  		let fillPart = (Math.asin(2 * remainderStar - 1) / Math.PI + 0.5)*100 | 0;
  		let starName = "currentStar" + fullStarsNumber
  		document.getElementById(starName).style.width = fillPart + '%';
    });

    if(this.props.isAuthenticated) {
        userData.then(userProfile => {

        imageUploader.imageMount(userProfile.userPhoto, document.querySelector("#userPhotoView"));
        imageUploader.imageMount(userProfile.userDiploma, document.querySelector("#diplomaScreenView"));

        let result = Object.assign({}, userProfile, {
          experience:formatDateUtils.formatToHtmlDateInput(new Date(userProfile.experience)),
          birthday:formatDateUtils.formatToHtmlDateInput(new Date(userProfile.birthday))
        });
        this.setState(result);
      });
    } else {
          userData.then(userProfile => {

          imageUploader.imageMount(userProfile.userPhoto, document.querySelector("#userPhotoView"));
          imageUploader.imageMount(userProfile.userDiploma, document.querySelector("#diplomaScreenView"));

          let result = Object.assign({}, userProfile, {
            experience:formatDateUtils.formatToHtmlDateInput(new Date(userProfile.experience)),
            birthday:formatDateUtils.formatToHtmlDateInput(new Date(userProfile.birthday))
          });
          this.setState(result);
        });
    }

//===========Comments================
    let commentByIdState  = this.props.commentByIdState;

    if (commentByIdState !== commentByIdStateType.empty
      && commentByIdState !== commentByIdStateType.outOfDate) {
        return;
      }
      userCommentList.then(commentList => {
        let commentById = {};
        commentList.forEach(comment => {
          commentById[comment.id] = comment;
        });
        this.props.dispatch(setCommentById(commentById));
      });
//===========Comments================
  }

  render(){
    return(
      <div>
        <UserHeader
          name={this.state.name}
          surname={this.state.surname}
          speciality={this.state.speciality}
          location={this.state.location}
        />
        <UserData
          essay={this.state.essay}
          price={this.state.price}
          currency={this.state.currency}
          experience={this.state.experience}
          birthday={this.state.birthday}
          phoneNumber={this.state.phoneNumber}
          email={this.state.email}
          linkedin={this.state.linkedin}
          facebook={this.state.facebook}
          skype={this.state.skype}
          university={this.state.university}
          userDiploma={this.state.userDiploma}
          history={this.props.history}
        />
      <CommentTreeContainer
          {...this.props}
          indent={20}/>
      </div>
    );
  }
}

const mapStateToProps = (state) => {
//===========Comments================
  var commentById = {};

  Object.values(state.server.commentList.commentById).forEach(comment => {
    let uiPartOfComment = state.ui.commentTree.uiPartOfCommentById[comment.id];
    commentById[comment.id] = Object.assign({}, comment, {
      expandType: uiPartOfComment.expandType
    });
  });
//===========Comments================

  let props = {
    isAuthenticated: state.server.user.isAuthenticated
  };
  return {
    props,
    commentById,
    commentByIdState: state.server.commentList.state
  };
};

//function
let reduxContainerCreator = connect(mapStateToProps);
//React component class
let ReduxUserDataContainer = reduxContainerCreator(UserDataContainer);

export default ReduxUserDataContainer;
