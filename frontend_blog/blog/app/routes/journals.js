import Ember from 'ember';

export default Ember.Route.extend({
  model() {
    return this.get('store').findAll('journal');
  },

  actions: {
    createRecord() {
      this.transitionTo('/journal/new');
    },

    editRecord(id) {
      this.transitionTo(`/journal/${id}`);
    }
  }
});
