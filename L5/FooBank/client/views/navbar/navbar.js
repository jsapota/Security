/**
 * Created by Jakub on 09.11.2017.
 */
Template.navbar.onCreated(function () {});
Template.navbar.helpers({
  logStatus: () => {
    return Meteor.user();
  },
  isActive: (route) => {
    if (route === FlowRouter.getRouteName())
      return "active";
  }
});

Template.navbar.events({
  'click .logoutButton': function() {
    Meteor.logout(function () {
      BlazeLayout.render('layout', {
        content: 'landing'
      });
    });
  }
});