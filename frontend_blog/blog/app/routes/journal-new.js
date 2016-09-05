import Ember from 'ember';

export default Ember.Route.extend({
  model() {

  },

  actions :{
    createRecord(params) {
      var journal = this.get('store').createRecord('journal', {
        title: `${params[0]}`,
        summary: `${params[1]}`,
        created: '03/03/2016'
      });
      journal.save();
      
      this.refresh();
      this.transitionTo('/journals');
    }
  }
});
