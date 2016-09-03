import Ember from 'ember';

export default Ember.Route.extend({
  actions: {
    open() {
      this.toggleProperty('isOpen');
    }
  }
});
