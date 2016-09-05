import Ember from 'ember';

export default Ember.Component.extend({
  store: Ember.inject.service(),

  actions: {
    editRecord(id) {
      this.sendAction('editRecord', id);
    }
  }
});
