import Ember from 'ember';

export default Ember.Route.extend({
  model(params) {
    return this.get('store').findRecord('journal', params.journal_id);
  },

  actions: {
    back() {
      this.transitionTo('/journals');
    },
    delete(id) {
      this.store.findRecord('journal', id, { backgroundReload: false }).then(function (post) {
        post.destroyRecord(); // => DELETE to /posts/2
      });
      this.transitionTo('/journals');
    }
  }
});
