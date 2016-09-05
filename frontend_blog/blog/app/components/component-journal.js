import Ember from 'ember';

export default Ember.Component.extend({
  actions: {
    back() {
      this.sendAction('back');
    },
    delete(id) {
      this.sendAction('delete', id);
    }
  }
});
