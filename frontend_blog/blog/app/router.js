import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType
});

Router.map(function() {
  this.route('welcome', {path: '/'});//welcome page
  this.route('aboutme', {path: '/aboutme'});//aboutme page
  this.route('journals', {path: '/journals'});//journals.hbs, journals.js
  this.route('journal-new', {path: '/journal/new'});
  this.route('journal-edit', {path: '/journal/:journal_id'});//journal.hbs, journal.js
});

export default Router;
