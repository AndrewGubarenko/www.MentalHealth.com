import React from 'react';

export default class UserData extends React.Component {
  render() {
    return(
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
              <label type="text">{this.props.price} </label>
              <label type="text">{this.props.currency}</label>
            </div>
          </div>
          <div className="data_list_container">
            <div className="name_label">
              <label>I am working since:</label>
            </div>
            <div className="respond">
              <label type="date">{this.props.experience}</label>
            </div>
          </div>
          <div className="data_list_container">
            <div className="name_label">
              <label>The day of my Birthday is:</label>
            </div>
            <div className="respond">
              <label type="text">{this.props.birthday}</label>
            </div>
          </div>
        </section>

        <section id="content-tab2">
          <div className="data_list_container">
            <div className="name_label">
              <label>Short about me:</label>
            </div>
            <div className="respond">
              <label type="text">{this.props.essay}</label>
            </div>
          </div>
        </section>

        <section id="content-tab3">
          <div className="data_list_container">
            <div className="name_label">
              <label>My phone number is:</label>
            </div>
            <div className="respond">
              <label type="text">{this.props.phoneNumber}</label>
            </div>
          </div>
          <div className="data_list_container">
            <div className="name_label">
              <label>My work eMail is:</label>
            </div>
            <div className="respond">
              <label type="email">{this.props.email}</label>
            </div>
          </div>
          <div className="data_list_container">
            <div className="name_label">
              <label>Here is my LinkedIn profile:</label>
            </div>
            <div className="respond">
              <label type="href">{this.props.linkedin}</label>
            </div>
          </div>
          <div className="data_list_container">
            <div className="name_label">
              <label>I'm on Facebook:</label>
            </div>
            <div className="respond">
              <label type="href">{this.props.facebook}</label>
            </div>
          </div>
          <div className="data_list_container">
            <div className="name_label">
              <label>Find me in Skype:</label>
            </div>
            <div className="respond">
              <label type="text">{this.props.skype}</label>
            </div>
          </div>
        </section>

        <section id="content-tab4">
          <div className="data_list_container">
            <div className="name_label">
              <label>I studied at:</label>
            </div>
            <div className="respond">
              <label type="text">{this.props.university}</label>
            </div>
          </div>
          <div className="data_list_container">
            <div id="diplomaScreenContainerView">
              <img id="diplomaScreenView" alt="" />
            </div>
          </div>
        </section>
      </div>
    );
  }
}
