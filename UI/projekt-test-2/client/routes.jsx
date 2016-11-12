import React from 'react';
import {mount} from 'react-mounter';

import Index from '../imports/ui/Index.jsx';
import Machines from '../imports/ui/Machines.jsx';
import {dashboard} from '../imports/ui/Dashboard.jsx';
import CustomerCenter from '../imports/ui/CustomerCenter.jsx';
import ProductLayout from '../imports/ui/ProductLayout.jsx';
import ProductDetail from '../imports/ui/ProductDetail.jsx';
import CustomerDetail from '../imports/ui/CustomerDetail.jsx';


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
        content: (<Machines/>)
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
        content: (<CustomerDetail id = {params.id}/>)
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
        content: (<ProductDetail id = {parseInt(params.id)}/>)
      }

      )
  }
});
