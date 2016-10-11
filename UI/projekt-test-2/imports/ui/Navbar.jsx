import React, { Component } from 'react';
import {Navbar, Nav, NavItem, Glyphicon, FormGroup, ControlLabel, FormControl} from 'react-bootstrap';


const navbarInstance = (
  <Navbar inverse>
    <Navbar.Header>
      <Navbar.Brand>
        <img src="logo_red_white.png" />
      </Navbar.Brand>
      <Navbar.Toggle />
    </Navbar.Header>
    <Navbar.Collapse>
      <Nav>
        <NavItem eventKey={1} href="machines">Machine Overview</NavItem>
        <NavItem eventKey={2} href="customerCenter">Customer Center</NavItem>
        <NavItem eventKey={3} href="productAnalysis">Product Analysis</NavItem>
      </Nav>
      <Navbar.Form pullRight>
          <FormGroup>
            <FormControl type="text" placeholder="Search" />
            <FormControl.Feedback>
              <Glyphicon glyph="search" />
            </FormControl.Feedback>
          </FormGroup>
      </Navbar.Form>
    </Navbar.Collapse>
  </Navbar>
);

export default React.createClass({


  render() {
      return (
          navbarInstance
            );
        }
  });
