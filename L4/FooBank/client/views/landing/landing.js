/**
 * Created by Jakub on 09.11.2017.
 */
Template.landing.onCreated(function () {
  Accounts._loginButtonsSession.set('dropdownVisible', true);
});

Template.landing.onRendered(function () {
  if(Meteor.user())
    FlowRouter.go("/transfer");
  else
    FlowRouter.go("/");
});

Template.landing.helpers({});

Template.landing.events({
  'click .login-button': () => {
    // BlazeLayout.render('layout', {
    //   content: 'transfer'
    // });
    FlowRouter.go("/transfer");
  }
});
