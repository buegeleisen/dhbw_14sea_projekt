import React from 'react';
import {mount} from 'react-mounter';

import Index from '../imports/ui/Index.jsx';
import Machines from '../imports/ui/Machines.jsx';
import {dashboard} from '../imports/ui/Dashboard.jsx';
import CustomerCenter from '../imports/ui/CustomerCenter.jsx';
import ProductAnalysis from '../imports/ui/ProductAnalysis.jsx';

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

FlowRouter.route('/productanalysis', {
  action() {
      mount(dashboard, {
        content: (<ProductAnalysis/>)
      }

      )
  }
});