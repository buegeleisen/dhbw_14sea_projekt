import React, { Component } from 'react';
import {Table} from 'react-bootstrap';
import {TableElement} from './TableElement.jsx';



export default class ProductLayout extends Component {

  getTableCells() {
    return [
      { id: 1, text: 'This is task 1', text2: 'Text1' },
      { id: 2, text: 'This is task 1', text2: 'Text1' },
      { id: 3, text: 'This is task 1', text2: 'Text1' },
    ];
  }


  renderTable(){
    return this.getTableCells().map((tableText) => (
      <TableElement key={tableText.id} tableText={tableText} />
    ));
  }



  render() {
    const productAnalysis = (
      { id: 1, text: 'This is task 1', text2: 'Text1' }
    );

      return (
        <div className="col-md-12">
          <div >
            <h1 className="section-heading">Product Overview</h1>
          </div>

          <Table responsive>
        <thead>
          <tr>
            <th>Product Number</th>
            <th>Customer Number</th>
            <th>Order Number</th>
          </tr>
        </thead>
        <tbody>
          <TableElement tableText={'Test'}/>
        </tbody>
      </Table>

        </div>
            );
        }
  };
