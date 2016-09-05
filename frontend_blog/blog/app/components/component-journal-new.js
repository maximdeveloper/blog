import Ember from 'ember';

export default Ember.Component.extend({
  actions:{
    createRecord() {
      var params = [`${this.get('title')}`, `${this.get('summary')}`];
      this.sendAction('createRecord', params);
    }
  }
});
