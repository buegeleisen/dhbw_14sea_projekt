import React, { Component } from 'react';
import {Button, Table} from 'react-bootstrap';
import {CustomerCenterData} from '../api/customerData.js';

const customerCenter = (
  <div className="col-md-12 container">
    <div>
      <h1 className="section-heading">Customer Center</h1>
      </div>
      <Table responsive>
    <thead>
      <tr>
        <th>Customer Number</th>
        <th>Customer Name</th>
        <th>Order Number</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>1</td>
        <td>Table cell</td>
        <td>Table cell</td>
      </tr>
      <tr>
        <td>2</td>
        <td>Table cell</td>
        <td>Table cell</td>
      </tr>
      <tr>
        <td>3</td>
        <td>Table cell</td>
        <td>Table cell</td>
      </tr>
    </tbody>
  </Table>

  </div>
);

export default React.createClass({


  render() {
      return (
          customerCenter
            );
        }
  });
