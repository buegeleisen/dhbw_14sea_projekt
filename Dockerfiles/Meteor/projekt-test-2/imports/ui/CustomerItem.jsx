import React, { Component, PropTypes } from 'react';
import {Panel, Glyphicon} from 'react-bootstrap';

export default class CustomerItem extends Component{

  render() {
      return (
        <div className="productList">
          <Panel>
            <div className="myPanel">
              <div className="col-md-10">
                <p>CustomerID: </p>
                <p>{this.props.customerid}</p>
              </div>
              <div className="col-md-2 click">
                <a href={"/customercenter/" + this.props.customerid}>
                  <Glyphicon glyph="chevron-right" />
                </a>
              </div>
            </div>
          </Panel>
        </div>
            );
        }
  };

CustomerItem.propTypes= {
  customerid: PropTypes.number,
};
