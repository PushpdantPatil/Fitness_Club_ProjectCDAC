import React from "react";
import {Link} from 'react-router-dom';
import { useState,useEffect } from "react";
import axios from "axios";
import { url } from "../../common/constant";
//import $ from "jquery";
import Navbar from "../../components/Navbar";
// import { Link } from "react-router-dom";
import { useHistory } from "react-router-dom";
//import { useSelector } from "react-redux";

const AllBranches = () => {
    const [branches, setBranch] = useState([]);
    const history = useHistory(); 

    //const isLogIn = useSelector((state) => state.isSignin);

    // if(isLogIn.status === false){
    //     alert('please signin first!!')
    //     history.push('/signin')
    //   }

    useEffect(() => {
        console.log("branch component is mounted");
        getBranch();
    
    } , []);

    const getBranch = () => {
        axios.get(url+"/branch/branch").then((response) => {
            const result = response.data;
            console.log(result);
            if (result.status === "OK" ) {
                setBranch(result.response);
            }else{
                alert("branches not found");
            }
        });
    }

    const deleteBranch = (branch) => {
        console.log(branch.id);
        axios.delete(url+"/branches/delete/"+branch.id).then((response) => {
            const result = response.data;
            if(result.status === "OK"){
                getBranch();
            }else{
                alert("error while user deletion");
            }
        })
    }

    // const updateBranch = (branch) => {
    //     console.log(branch.id);
    //     axios.put(url+"/branches/update").then((response) => {
    //         const result = response.data;
    //         if(result.status === "OK"){
    //             getBranch();
    //         }else{
    //             alert("error while updating branch");
    //         }
    //     })
    // }

    return(
        <div className="privacydiv">
             <Navbar/>

             <Link to="/addbranch"> <a className="btn btn-warning" href=" ">Add Branch</a> </Link>
            <h1 align="center">All Branches</h1> 
            <table className="table">
                <thead class="thead-dark">
                
                    <tr>
                        <th>Id</th>
                        <th>Branch Name</th>
                        <th>Locality</th>
                        <th>City</th>
                        <th>State</th> 
                        <th>Zipcode</th>  
                        <th>Phone</th>                 
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody id="myTable">
                    {
                        branches.length >= 1 ? branches.map(branch => {
                            return(
                                <tr key={branch.id}>
                                    <td>{branch.id}</td>
                                    <td>{branch.branchName}</td>
                                    <td>{branch.locality}</td>
                                    <td>{branch.city}</td>
                                    <td>{branch.state}</td>
                                    <td>{branch.zipCode}</td>
                                    <td>{branch.phoneNo}</td>
                                    <td>
                                        <button type="button" class="btn btn-danger" onClick={()=>{deleteBranch(branch)}}>
                                           Delete
                                        </button>&nbsp;&nbsp;&nbsp;
                                        <button type="button" class="btn btn-light" onClick={()=>{
                                 history.push('/updatebranch', {branches:branch})
                                }}>
                                           Edit
                                        </button>&nbsp;&nbsp;&nbsp;

                                        <button type="button" class="btn btn-dark" onClick={()=>{
                                 history.push('/branchpage', {branch:branch})
                                }}>
                                           View
                                        </button>
                                    </td>
                                </tr>
                            )
                        }):''
                    }
                </tbody>
            </table>   


            <div className="mb-3">
             
            
            <Link to="/adminpage">
               &nbsp;&nbsp; <button className="btn btn-primary">Back</button>
            </Link>
            </div>


        </div>
    )
}


export default AllBranches;