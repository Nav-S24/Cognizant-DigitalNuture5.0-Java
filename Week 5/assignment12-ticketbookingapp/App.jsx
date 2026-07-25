import React, { Component } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';
import { LoginButton, LogoutButton } from './LoginLogoutButtons';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = { isLoggedIn: false };

    this.handleLoginClick = this.handleLoginClick.bind(this);
    this.handleLogoutClick = this.handleLogoutClick.bind(this);
  }

  handleLoginClick() {
    this.setState({ isLoggedIn: true });
  }

  handleLogoutClick() {
    this.setState({ isLoggedIn: false });
  }

  render() {
    const isLoggedIn = this.state.isLoggedIn;

    // Element variable — which button to render depends on login state
    let loginControl;
    if (isLoggedIn) {
      loginControl = <LogoutButton onClick={this.handleLogoutClick} />;
    } else {
      loginControl = <LoginButton onClick={this.handleLoginClick} />;
    }

    return (
      <div>
        <h1>Flight Ticket Booking</h1>
        {loginControl}
        {isLoggedIn ? <UserPage /> : <GuestPage />}
      </div>
    );
  }
}

export default App;
