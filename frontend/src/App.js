import React, {Component} from 'react';
import './App.css';

class App extends Component {

    constructor(){
        super();
        this.state = {
            list :[],
        };
    }




    componentDidMount() {
        setInterval(this.hello, 250);
        setInterval(this.names, 250);
    }

    hello = () => {
        fetch('/api/hello')
            .then(response => response.text())
            .then(message => {
                this.setState({message: message});
            });
    };

    names = () => {
        fetch('/api/names')
            .then(response => response.json())
            .then(list => {
                this.setState({list:list});
            });
    };
    render() {
        return (

            <div className="App">
               <div className="App2">
                   {this.state.list}
               </div>
                </div>
        );
    }
}




export default App;
