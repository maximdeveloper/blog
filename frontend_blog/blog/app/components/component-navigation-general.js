import Ember from 'ember';

export default Ember.Component.extend({
  tagName: 'div',
  currentElement: null,

  didReceiveAttrs() {
    // $('.collapsible').collapsible({
    //   accordion : false // A setting that changes the collapsible behavior to expandable instead of the default accordion style
    // });
  },

  getById(value) {
    return '#'+value;
  },

  getByClass(value) {
    return '#'+value;
  },

  click(e) {
    if(this.get('currentElement') === null) {
      this.set('currentElement', $('a[href="/"]'));
    }

    if(this.get('currentElement').href != e.target.href) {
      //remove css class from current element
      var currentElement = this.getById(this.get('currentElement').id);
      $(currentElement).closest('li').removeClass('active');
      //add css class to new select element
      this.set('currentElement', e.target);
      var newSelectedElement = this.getById(this.get('currentElement').id);
      $(newSelectedElement).closest('li').addClass('active');
    }
//change route -> sideNav will hide
    $('.button-collapse').sideNav('hide');
  }
});
