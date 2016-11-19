import React from 'react';
import {mount} from 'react-mounter';

import Index from '../imports/ui/Index.jsx';
import Machines2 from '../imports/ui/Machines2.jsx';
import {dashboard} from '../imports/ui/Dashboard.jsx';
import CustomerCenter from '../imports/ui/CustomerCenter.jsx';
import ProductLayout from '../imports/ui/ProductLayout.jsx';
import ProductDetailLayout from '../imports/ui/ProductDetailLayout.jsx';
import CustomerDetailLayout from '../imports/ui/CustomerDetailLayout.jsx';


FlowRouter.route('/', {
  action() {
      mount(dashboard, {
        content: (<Index/>)
      }

      )
  }
});
FlowRouter.route('/machines', {
  action() {
      mount(dashboard, {
        content: (<Machines2/>)
      }

      )
  }
});

FlowRouter.route('/customercenter', {
  action() {
      mount(dashboard, {
        content: (<CustomerCenter/>)
      }

      )
  }
});

FlowRouter.route('/customercenter/:id', {
  action(params) {
      mount(dashboard, {
        content: (<CustomerDetailLayout id = {params.id}/>)
      }

      )
  }
});

FlowRouter.route('/products', {
  action() {
      mount(dashboard, {
        content: (<ProductLayout/>)
      }

      )
  }
});


FlowRouter.route('/products/:id', {
  action(params) {
      mount(dashboard, {
        content: (<ProductDetailLayout id = {params.id}/>)
      }

      )
  }
});
