import React from 'react';
import './../css/UserViewProfile.css'

const getExpandSpan = (expandType) => {
  if(expandType === "isExpanded") {
    return(
      <span className="roll-up">&#5123;</span>
    );
  }

  if(expandType === "isNotExpanded") {
    return(
      <span className="roll-down">&#5121;</span>
    );
  }

  if(expandType === "canNotBeExpanded") {
    return null;
  }

  return null;
}

const dropDown = () => {
  //let a = document.getElementById("dropdown-menu");
  // if ( a.style.display == 'none' )
  //   a.style.display = 'block';
  // else
  //   if ( a.style.display == 'block' )
  //   a.style.display = 'none';
}

const Comment = ({name, comment, commentIsVisible, expandType}) => {
  return(
    <div>
      <div style={{display: "flex", flexDirection: "row", justifyContent: "space-between", alignItems: "center", padding: "5px"}}>
        <div style={{width: "20px", fontSize: "7pt"}}>
          {getExpandSpan(expandType)}
        </div>
        <div style={{flexGrow: 1}}>
          <span className="font-weight-bold" style={{cursor: "pointer"}}>
            {name}
          </span>
        </div>

        <div style={{width: "30px"}}>
          <div className="dropdown-btn-group" role="group">
            <a className="dropdown-btn" onClick={dropDown()}>&#5121;</a>
              <ul id="dropdown-menu">
                <li className="dropdown-item">Reply</li>
              </ul>
          </div>
        </div>

      </div>
      {
        commentIsVisible ? (
          <div style={{marginLeft: "20px", marginRight: "50px", color: "grey", fontStyle: "italic"}}>
            {comment}
          </div>
        ): undefined}
    </div>
  );
};

const longComment = "Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here Some comment here "

export default class UserViewProfile extends React.Component {

  render() {
    return(
      <div id="userContainer">
    		<div id="userData">

          <div id="person_container">
            <div id="cover">
              <div id="name">
                <label>Andrii</label> <label>Hubarenko</label>
              </div>
            </div>
            <div id="photoContainerView">
              <img id="userPhotoViev" alt="" />
            </div>
            <div id="speciality">
              <label>ATCO</label>
            </div>
          </div>

          <div className="tabs">
            <input id="tab1" type="radio" name="tabs" defaultChecked />
            <label htmlFor="tab1" title="Information">Information</label>

            <input id="tab2" type="radio" name="tabs" />
            <label htmlFor="tab2" title="About me">About me</label>

            <input id="tab3" type="radio" name="tabs" />
            <label htmlFor="tab3" title="Contacts">Contacts</label>

            <section id="content-tab1">
              <div className="data_list_container">
                <div className="name_label">
                	<label>My prise is:</label>
                </div>
                <div className="respond">
                	<label>800 </label>
                	<label>USD</label>
                </div>
              </div>
  			      <div className="data_list_container">
                <div className="name_label">
                	<label>I am working since:</label>
                </div>
                <div className="respond">
                	<label>01.11.2010</label>
                </div>
        			</div>
        			<div className="data_list_container">
                <div className="name_label">
                	<label>The day of my Birthday is:</label>
                </div>
                <div className="respond">
    				      <label>22.10.1988</label>
                </div>
              </div>
  			      <div className="data_list_container">
                <div className="name_label">
                	<label>My rating on this site is:</label>
                </div>
                <div className="respond">
                	<label>7.0</label>
                </div>
        			</div>
            </section>
            <section id="content-tab2">
              <div className="data_list_container">
                <div className="name_label">
                  <label>Short about me:</label>
                </div>
                <div className="respond">
                  <label>Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story Some story</label>
                </div>
              </div>
            </section>
            <section id="content-tab3">
              <div className="data_list_container">
                <div className="name_label">
                	<label>My phone number is:</label>
                </div>
                <div className="respond">
                	<label>+380504121271</label>
                </div>
        			</div>
        			<div className="data_list_container">
                <div className="name_label">
                	<label>My work eMail is:</label>
                </div>
                <div className="respond">
                	<label>MyMail@email.com</label>
                </div>
        			</div>
        			<div className="data_list_container">
                <div className="name_label">
                	<label>Here is my LinkedIn profile:</label>
                </div>
                <div className="respond">
                	<label>
                		<a href="LinkedIn.link" target="_blank">LinkedIn.link</a>
                	</label>
                </div>
        			</div>
        			<div className="data_list_container">
                <div className="name_label">
                	<label>I'm on Facebook:</label>
                </div>
                <div className="respond">
                	<label>
                		<a href="Facebook.link" target="_blank">Facebook.link</a>
                	</label>
                </div>
        			</div>
        			<div className="data_list_container">
                <div className="name_label">
                	<label>Find me in Skype:</label>
                </div>
                <div className="respond">
                	<label>MySkypeNickname</label>
                </div>
        			</div>
            </section>
          </div>

	      </div>

        <div id="comments_container">
    			<div id="buttonContainer">
            <div id="button">
          		<div id="inscription"><span id="plus">+</span>New comment</div>
          		<div id="bottom-border"></div>
          		<div id="right-border"></div>
          	</div>
    			</div>
    			<div className="comment_box">
    				<Comment name="Comment" commentIsVisible={true} comment={longComment} expandType="isExpanded" />
    			</div>
    			<div className="comment_box">
    				<Comment name="Comment" expandType="isExpanded" />
    			</div>
    			<div className="comment_box">
    				<Comment name="Comment" expandType="canNotBeExpanded" />
    			</div>
    			<div className="comment_box">
    				<Comment name="Comment" expandType="isExpanded" />
    			</div>
    			<div className="comment_box">
    				<Comment name="Comment" expandType="isNotExpanded" />
    			</div>
    		</div>

      </div>
    );
  }
}
