import React, { Component } from 'react';
import {Button, Table} from 'react-bootstrap';
import CustomerItem from'./CustomerItem.jsx';

const panel= (
<div className="col-md-12 container">
  <div>
    <h1 className="section-heading">Customers and Orders Center</h1>
  </div>
  <div>
    <CustomerItem orderid={1234} customerid={4567} productid={1337}/>
    <CustomerItem orderid={5678}/>
  </div>

</div>
);
export default React.createClass({


  render() {
      return (
          panel
            );
        }
  });
