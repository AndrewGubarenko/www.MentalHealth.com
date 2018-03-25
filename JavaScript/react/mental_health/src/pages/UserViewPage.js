import React from 'react';
import './../css/UserViewProfile.css';
import CommentTreeContainer from './../containers/CommentTreeContainer';

export default class UserViewProfile extends React.Component {
  getMode() {
    if(this.props.match.path === "/UserViewPage/comment/:parentId?") {
      return "new";
    }
    if(this.props.match.path === "/UserViewPage/:id") {
      return "view";
    }
    throw new Error("Unknown url!");
  }

  render() {
    return(
      <div>

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
          <div id="location">
            <label>Kyiv</label>
          </div>
        </div>

        <div id="data_container">

          <div className="tabs">
            <input id="tab1" type="radio" name="tabs" defaultChecked />
            <label htmlFor="tab1" title="Information">Information</label>

            <input id="tab2" type="radio" name="tabs" />
            <label htmlFor="tab2" title="About me">About me</label>

            <input id="tab3" type="radio" name="tabs" />
            <label htmlFor="tab3" title="Contacts">Contacts</label>

            <input id="tab4" type="radio" name="tabs" />
            <label htmlFor="tab4" title="Contacts">Diploma</label>

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
            <section id="content-tab4">
              <div className="data_list_container">
                <div id="diplomaScreenContainerView">
                  <img id="diplomaScreenPhotoViev" alt="" />
                </div>
              </div>
            </section>
          </div>

          <CommentTreeContainer
            history={this.props.history}
            mode={this.getMode()}
            id={this.props.match.params.id}
            parentId={this.props.match.params.parentId} />

          <div className="line"/>

        </div>
      </div>
    );
  }
}
