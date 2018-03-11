import React from 'react';
import PropTypes from 'prop-types';
import { Field, reduxForm } from 'redux-form';
const log = require('simple-console-logger').getLogger('NavBrand');

/**
 * The left-most brand tag on the navbar
 */
class NavBrand extends React.Component {
    render() {
        return (
            <a className="navbar-brand" href='/'>
                {this.props.name} 
            </a>
        )
    }
}

export default NavBrand;