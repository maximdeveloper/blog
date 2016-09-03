import Ember from 'ember';

export default Ember.Route.extend({
  model() {
    return this.get('store').findAll('journal');
  },

  actions: {
    createRecord() {
      var journal = this.store.createRecord('journal', {
        title: 'Rails is Omakase',
        summary: 'Lorem ipsum',
        created: '03/03/2016'
      });
      journal.save();
    },

    deleteRecord(value) {
      this.store.findRecord('journal', value, { backgroundReload: false }).then(function (post) {
        post.destroyRecord(); // => DELETE to /posts/2
      });
    }
  }
});
