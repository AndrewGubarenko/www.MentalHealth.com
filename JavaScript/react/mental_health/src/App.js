import React from 'react'
import NavigationBar from './components/NavigationBar'
import WelcomeContent from './components/WelcomeContent'
import RegistrationContainer from './containers/RegistrationContainer'
import AuthenticationContainer from './containers/AuthenticationContainer'
import UserCreateContainer from './containers/UserCreateContainer'
import Footer from './components/Footer'

import {HashRouter, Route} from 'react-router-dom'

class App extends React.Component {
  render() {
    return (
      <HashRouter>
        <div>
          <header>
            <Route path="/" component={NavigationBar}/>
          </header>
          <Route exact path="/" component={WelcomeContent}/>
          <Route exact path="/registration" component={RegistrationContainer}/>
          <Route exact path="/authentication" component={AuthenticationContainer}/>
          <Route exact path="/UserCreate" component={UserCreateContainer}/>
          <footer>
            <Footer />
          </footer>
        </div>
      </HashRouter>
    )
  }
}

export default App;
