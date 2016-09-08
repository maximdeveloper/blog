import Ember from 'ember';

export default Ember.Route.extend({
  model() {

  },

  actions :{
    createRecord(params) {
      if($.inArray('undefined', params) != -1 || $.inArray('', params) != -1) {
        this.notify.info('Fields cannot be empty');
        return;
      }

      var journal = this.get('store').createRecord('journal', {
        title: `${params[0]}`,
        summary: `${params[1]}`,
        created: '03/03/2016'
      });

      journal.save().then((journal) => {
        this.notify.success('Note has been created');
        this.refresh();
        this.transitionTo('/journals');
      }).catch(exception => {
        this.notify.warning('Error when adding note');
      });
    }
  }
});
