import React, { Component } from 'react';
import Navbar from './Navbar.jsx';

export const dashboard = ({content}) => (
<div className="dashboard">
  <Navbar/>
  <div className="dashboard-layout">
    {content}
  </div>
</div>

);
