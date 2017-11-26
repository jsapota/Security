/**
 * Created by Jakub on 09.11.2017.
 */
Template.history.onCreated(function () {

});

Template.history.helpers({
  'history': () => {
    return Transfers.find();
  }
});

Template.history.events({

});