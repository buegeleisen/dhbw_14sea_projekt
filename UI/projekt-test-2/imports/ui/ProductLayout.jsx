import React, { Component, PropTypes } from 'react';
import MyPanel from './MyPanel.jsx';



export default class ProductLayout extends Component {
  getTableCells() {
    return [
      { id: 1, text: "This is task 1", text2: "Text1" },
      { id: 2, text: "This is task 1", text2: "Text1" },
      { id: 3, text: "This is task 1", text2: "Text1" },
    ];
  }


  /*renderTable(){
    return this.getTableCells().map((item) => (

    ));
  }*/


  render() {


  const render =(
    <div className="col-md-12 container">
      <div>
        <h1 className="section-heading">Product Overview</h1>
      </div>
      <div>
        <MyPanel _id="nummer1" timestamp={12345} customer="MyCustomer" />
        <MyPanel _id="nummer2"/>
      </div>

    </div>

  );
      return (
          render
            );
        }
  };
