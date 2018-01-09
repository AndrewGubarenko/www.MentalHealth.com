import React from 'react';
import NavigationBarContainer from './containers/NavigationBarContainer';
import WelcomeContent from './components/WelcomeContent';
import RegistrationContainer from './containers/RegistrationContainer';
import AuthenticationContainer from './containers/AuthenticationContainer';
import UserEditorPage from './pages/UserEditPage';
import Footer from './components/Footer';
import './css/FormStyle.css';

import {HashRouter, Route} from 'react-router-dom';

class App extends React.Component {
  render() {
    return (
      <HashRouter>
        <div>
          <header>
            <Route path="/" component={NavigationBarContainer} />
          </header>

          <Route exact path="/" component={WelcomeContent} />
          <Route exact path="/registration" component={RegistrationContainer} />
          <Route exact path="/authentication" component={AuthenticationContainer} />

          <Route exact path="/UserEditor/new/" component={UserEditorPage} />
          <Route exact path="/UserEditor/edit/:id" component={UserEditorPage} />

          <footer>
            <Route path="/" component={Footer} />
          </footer>
        </div>
      </HashRouter>
    )
  }
}

export default App;
