import React from 'react';
import PropTypes from 'prop-types';
import { Field, reduxForm } from 'redux-form';
import TaskList from './TaskList';
import Task from './Task';
const log = require('simple-console-logger').getLogger('TaskContainer');

function taskPage(id) {
    var task = null; //todo: put in http call for back end api
    return (
        <Task task={task} />
    )
}

function taskList() {
    var tasks = null; //todo: put in http call for back end api
    return (
        <TaskList tasks={tasks} />
    )
}

/**
 * Display the contents of a single task
 */
class TaskContainer extends React.Component {
    render() {
        return (
            <div className='container-fluid'>
                {this.props.id ? taskPage(this.props.id) : taskList()}
            </div>
        )
    }
}

export default TaskContainer;