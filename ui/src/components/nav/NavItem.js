import React from 'react';
import PropTypes from 'prop-types';
import { Field, reduxForm } from 'redux-form';
const log = require('simple-console-logger').getLogger('NavItem');

/**
 * Display a simple form with buttons to say hello. The
 * message field uses redux-form as an example of validation.
 */
class NavItem extends React.Component {
    render() {
        return (
            <div>
                <li className="nav-item active">
                    <a className="nav-link" href={this.props.path}>
                        {this.props.name} 
                        <span className="sr-only">
                            (current)
                        </span>
                    </a>
                </li>
            </div>
        )
    }
}

export default NavItem;