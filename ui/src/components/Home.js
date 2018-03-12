import React from 'react';
const log = require('simple-console-logger').getLogger('Home');

/**
 * Display a simple form with buttons to say hello. The
 * message field uses redux-form as an example of validation.
 */
class Home extends React.Component {
    render() {
        return (
            <div>
                <p>
                    Home is where I belong
                </p>
            </div>
        )
    }
}

export default Home;