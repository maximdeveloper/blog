import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType
});

Router.map(function() {
  this.route('welcome', {path: '/'});//welcome page
  this.route('aboutme', {path: '/aboutme'});//aboutme page
  this.route('journals', {path: '/journals', resetNamespace: true}, function() {
    this.route('journal', {path: ':journal_id'});//journal.hbs, journal.js
  });//journals.hbs, journals.js
});

export default Router;
