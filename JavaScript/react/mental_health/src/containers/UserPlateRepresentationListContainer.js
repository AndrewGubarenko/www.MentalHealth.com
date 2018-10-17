import React from 'react';
import {connect} from 'react-redux';
import UserRepresentationPlateList from './../components/UserRepresentationPlateList';
import {visitorService, imageUploader} from './../appContext/Context';
import {setUserPlateById} from './../store/server/userPlate/UserPlateAction';

class UserPlateRepresentationListContainer extends React.Component {

  componentDidMount() {

    visitorService.getShortUserProfileListRepresentation().then(data => data.json()).then(data => {
      data.forEach(dataMass => {

        let user = dataMass[0];
        let rating = dataMass[1];

        let getRating = () => {
          if(isNaN(rating)) {
            return 0;
          } else {
            return rating;
          }
        }

        let getExperience = () => {
          let fullYears = (new Date().getFullYear() - new Date(user.experience).getFullYear());
          if(fullYears > 0) {
            return fullYears + " years of experiense";
          } else {
            return new Date().getMonth() - new Date(user.experience).getMonth() + "  month of experiense"
          }
        }

        let userPlateById =  Object.assign({}, user, {
          experience: getExperience(),
          rating: getRating()
        });

        this.props.dispatch(setUserPlateById(userPlateById));
        imageUploader.imageMount(user.userPhoto, document.querySelector("#user_photo_min"));

      })
    });
  }

  render() {
    return(
      <UserRepresentationPlateList
        {...this.props}
      />
    );
  }

}

const mapStateToProps = (state) => {
  let userPlateById = state.server.userPlateList.userPlateById;
  let props = {
    name:state.server.userPlateList.userPlateById.name,
    surname:state.server.userPlateList.userPlateById.surname,
    location:state.server.userPlateList.userPlateById.location,
    speciality:state.server.userPlateList.userPlateById.speciality,
    price:state.server.userPlateList.userPlateById.price,
    currency:state.server.userPlateList.userPlateById.currency,
    experience:state.server.userPlateList.userPlateById.experience,
    rating: state.server.userPlateList.userPlateById.rating
  };
  return {
    userPlateById,
    props
  };
}

export default connect(mapStateToProps)(UserPlateRepresentationListContainer);
