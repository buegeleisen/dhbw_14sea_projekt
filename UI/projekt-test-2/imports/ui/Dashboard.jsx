import React, { Component } from 'react';
import Navbar from './Navbar.jsx';
import Index from './Index.jsx';
import Machines from './Machines.jsx';

export const dashboard = ({content}) => (
<div className="dashboard">
  <Navbar/>
  <div className="dashboard-layout">
    {content}
  </div>
</div>

);
