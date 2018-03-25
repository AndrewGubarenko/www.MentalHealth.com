import React from 'react';
import NavigationBarContainer from './containers/NavigationBarContainer';
import WelcomeContent from './components/WelcomeContent';
import RegistrationContainer from './containers/RegistrationContainer';
import AuthenticationContainer from './containers/AuthenticationContainer';
import UserEditorPage from './pages/UserEditPage';
import UserViewPage from './pages/UserViewPage';
import MainPage from './pages/MainPage';
import Footer from './components/Footer';
import './css/FormStyle.css';

import {HashRouter, Route} from 'react-router-dom';
import {Provider} from 'react-redux';
import {store} from './appContext/Context';
import {setIsAuthenticated} from './store/user/UserActions';

class App extends React.Component {

  constructor(props) {
    super(props);
    let token = localStorage.getItem("token");
    store.dispatch(setIsAuthenticated(token !== null));
  }

  render() {
    return (
      <Provider store={store}>
        <HashRouter>
          <div>
            <header>
              <Route path="/" component={NavigationBarContainer} />
            </header>

            <Route exact path="/" component={WelcomeContent} />
            <Route exact path="/registration" component={RegistrationContainer} />
            <Route exact path="/authentication" component={AuthenticationContainer} />

            <Route exact path="/UserViewPage/:id" component={UserViewPage} />
            <Route exact path="/MainPage" component={MainPage} />

            <Route exact path="/UserEditor/new/" component={UserEditorPage} />
            <Route exact path="/UserEditor/edit/:id" component={UserEditorPage} />

            <footer>
              <Route path="/" component={Footer} />
            </footer>
          </div>
        </HashRouter>
      </Provider>
    )
  }
}

export default App;
