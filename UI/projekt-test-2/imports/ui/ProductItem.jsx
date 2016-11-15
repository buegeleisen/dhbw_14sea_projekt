import React, { Component, PropTypes } from 'react';
import {Panel, Glyphicon} from 'react-bootstrap';

export default class ProductItem extends Component{

  render() {
      return (
        <div className="productList">
          <Panel>
            <div className="myPanel">
              <div className="col-md-3">
                <p>ID: </p>
                <p>{this.props.id}</p>
              </div>
              <div className="col-md-4">
                <p>Timestamp: </p>
                <p>{this.props.timestamp}</p>
              </div>
              <div className="col-md-3">
                <p>Customer: </p>
                <p>{this.props.customer}</p>
              </div>
              <div className="col-md-2 click">
                <a href={"/products/" + this.props.id}>
                  <Glyphicon glyph="chevron-right" />
                </a>
              </div>
            </div>
          </Panel>
        </div>
            );
        }
  };

ProductItem.propTypes= {
  id: PropTypes.string,
  timestamp: PropTypes.string,
  customer: PropTypes.number
};
