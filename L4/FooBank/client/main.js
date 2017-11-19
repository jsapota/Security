import './main.html';

Template.loginButtons.rendered = function() {
  Accounts._loginButtonsSession.set('dropdownVisible', true);
};