import React from 'react';
const log = require('simple-console-logger').getLogger('UserListRow');

/**
 * Display the contents of a single UserListRow
 */
class UserListRow extends React.Component {
    render() {
        var user = this.props.user;
        return (
          <tr>
              <td>{user.id}</td>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>{user.position}</td>
              <td>
                <a href={"/user/" + user.id}>edit</a>
              </td>
          </tr>
        )
    }
}

export default UserListRow;