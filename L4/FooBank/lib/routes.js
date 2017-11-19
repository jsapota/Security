import {BlazeLayout} from 'meteor/kadira:blaze-layout';
import {FlowRouter} from 'meteor/kadira:flow-router';

FlowRouter.triggers.enter([function (context, redirect) {}]);

FlowRouter.route('/logout', {
  name: 'logout',
  action() {
    Accounts.logout();
    FlowRouter.go('/');
  }
});

FlowRouter.route('/', {
  name: "landing",
  action() { BlazeLayout.render('layout', {content: 'landing'})}
});

FlowRouter.route('/transfer', {
  name: "transfer",
  action() { BlazeLayout.render('layout', {content: 'transfer'})}
});

FlowRouter.route('/history', {
  name: "history",
  action() { BlazeLayout.render('layout', {content: 'history'})}
});
