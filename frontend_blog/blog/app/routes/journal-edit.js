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
      this.store.findRecord('journal', id, { backgroundReload: false }).then((post) => {
        post.destroyRecord(); // => DELETE to /posts/2
        this.notify.info('Note has been deleted');
      });

      this.transitionTo('/journals');
    }
  }
});
