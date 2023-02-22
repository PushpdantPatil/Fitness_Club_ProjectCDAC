import React, { lazy, Suspense } from 'react';
import {BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './common.css';
//import './App.css';

//imported browserrouter for routing in a spa and respctive changes in index,js

import ReviewContextProvider from './context/ReviewContext';
import TrainerContextProvider from './context/TrainerContext';
import Lazy from './components/Lazy';
import ErrorPage from './components/ErrorPage';

//import AllPackages from './screens/common/AllPackages';
//import AllMembers from './components/AllMembers';



function App() {
  const Home = lazy(() => import('./components/Home'));
 // const FitArmy = lazy(() => import('./components/FitArmy'));
  const Pricing = lazy(() => import('./components/Pricing'));
  const Contact = lazy(() => import('./components/Contact'));//
  const About = lazy(() => import('./components/About'));
  const IndividualExpert = lazy(() => import('./components/IndividualExpert'));
  
  const PrivacyPolicyScreen= lazy(() => import('./components/PrivacyPolicyScreen'));
  const TermsOfService= lazy(() => import('./components/TermsOfService'));
  // const Admin = lazy(() => import('./screens/common/Admin'));
  // const Member = lazy(() => import('./screens/common/Member'));
  // const Trainer = lazy(() => import('./screens/common/Trainer'));
  const SignIn = lazy(() => import('../src/screens/common/SignIn'));
  const AllMembers = lazy(() => import('../src/screens/common/AllMembers'));
  const AllTrainers = lazy(() => import('../src/screens/common/AllTrainers'));
  const AllLocalAdmins = lazy(() => import('../src/screens/common/AllLocalAdmins'));
  const AllBranches = lazy(() => import('../src/screens/common/AllBranches'));
  const AllBatches = lazy(() => import('../src/screens/common/AllBatches'));
  const AllPackages = lazy(() => import('../src/screens/common/AllPackages'));
  
  const MyTrainers = lazy(() => import('../src/screens/localadmin/MyTrainers'));
  const Trainers = lazy(() => import('./screens/member/Trainers'));
  const MyMembers = lazy(() => import('../src/screens/localadmin/MyMembers'));
  const BranchesList = lazy(() => import('../src/screens/member/BranchesList'));
  const PackagesList = lazy(() => import('../src/screens/member/PackagesList'));

  const Batches = lazy(() => import('../src/screens/localadmin/Batches'));
  const AdminPage = lazy(() => import('../src/screens/common/AdminPage'));
  const MemberPage = lazy(() => import('../src/screens/member/MemberPage'));
  const LocalAdminPage = lazy(() => import('../src/screens/common/LocalAdminPage'));
  const TrainerPage = lazy(() => import('../src/screens/common/TrainerPage'));
  const BranchPage = lazy(() => import('../src/screens/common/BranchPage'));
  const SignUp = lazy(() => import('./screens/common/SignUp'));
  const AddTrainer = lazy(() => import('../src/screens/common/AddTrainer'));
  const AddLocalAdmin = lazy(() => import('../src/screens/common/AddLocalAdmin'));
  const AddBranch = lazy(() => import('../src/screens/common/AddBranch')); 
  const AddPackage = lazy(() => import('../src/screens/common/AddPackage'));
  const AddBatch = lazy(() => import('../src/screens/common/AddBatch'));
  
 
  const AllPackagesList = lazy(() => import('../src/screens/localadmin/AllPackagesList'));
  const AllBranchesList = lazy(() => import('../src/screens/localadmin/AllBranchesList'));

  const UpdatePackage = lazy(() => import('../src/screens/common/UpdatePackage'));
  const UpdateBatch = lazy(() => import('../src/screens/common/UpdateBatch'));
  const UpdateBranch = lazy(() => import('../src/screens/common/UpdateBranch'));
  const UpdateLocalAdmin = lazy(() => import('../src/screens/common/UpdateLocalAdmin'));
  const UpdateMember = lazy(() => import('../src/screens/localadmin/UpdateMember'));
  const UpdateTrainer = lazy(() => import('../src/screens/localadmin/UpdateTrainer'));
  const ProfileMember = lazy(() => import('../src/screens/member/ProfileMember'));
  const ProfileLocal = lazy(() => import('./screens/member/ProfileLocal'));
  const MyBranchPage = lazy(() => import('../src/screens/localadmin/MyBranchPage'));
  //const UpdateMember = lazy(() => import('../src/screens/common/UpdateMember'));
  
  
  return (
    // <TrainerContextProvider>
    //     <Suspense fallback= {<Lazy/>}>
    //   <Switch>
    //       <Route exact path="/" component={Home} />
    //       <Route path="/home" component={Home} />
    //       <ReviewContextProvider>
    //         <Route path="/fitarmy" component={FitArmy} />
    //       </ReviewContextProvider>
    //       <Route path="/about" component={About} />
    //       <Route path="/price" component={Pricing} />
    //       <Route path="/contact" component={Contact} />
    //       <Route path="/register" component={SignUp} />
    //       <Route path='/error' component={ErrorPage} />
    //       <Route exact path="/staff/:id" component={IndividualExpert} />
    //       <Route component={ErrorPage} />
    //   </Switch>
    //     </Suspense>
    // </TrainerContextProvider>
    <TrainerContextProvider>
      <ReviewContextProvider>
        <Suspense fallback={<Lazy />}>
        <Router>
          <Switch>
            <Route exact path="/" component={Home} />
            <Route path="/home" component={Home} />
            <Route path="/about" component={About} />
            <Route path="/price" component={Pricing} />
            <Route path="/contact" component={Contact} />            
            <Route path='/error' component={ErrorPage} />
            <Route exact path="/staff/:id" component={IndividualExpert} />
            {/* <Route path="/fitarmy" component={FitArmy} /> */}
            <Route path="/privacypolicy" component={PrivacyPolicyScreen} />
            <Route path="/termsofservice" component={TermsOfService} />
            <Route path="/login" component={SignIn} />
            <Route path="/allmembers" component={AllMembers} />
            <Route path="/alltrainers" component={AllTrainers} />
            <Route path="/alllocaladmins" component={AllLocalAdmins} />
            <Route path="/allbranches" component={AllBranches} />
            <Route path="/allbatches" component={AllBatches} />
            <Route path="/allpackages" component={AllPackages} />
            
            <Route path="/adminpage" component={AdminPage} />
            <Route path="/memberpage" component={MemberPage} />
            <Route path="/localadminpage" component={LocalAdminPage} />
            <Route path="/branchpage" component={BranchPage} />
            <Route path="/mytrainers" component={MyTrainers} />
            <Route path="/mymembers" component={MyMembers} />

            <Route path="/trainerpage" component={TrainerPage} /> 
            <Route path="/register" component={SignUp} />          
            <Route path="/addtrainer" component={AddTrainer} />
            <Route path="/addlocaladmin" component={AddLocalAdmin} />
            <Route path="/addbranch" component={AddBranch} />
            <Route path="/addbatch" component={AddBatch} />
            <Route path="/addpackage" component={AddPackage} />
            
            <Route path="/packageslist" component={AllPackagesList} />
            <Route path="/brancheslist" component={AllBranchesList} />
            <Route path="/updatepackage" component={UpdatePackage} />
            <Route path="/updatebatch" component={UpdateBatch} />
            <Route path="/updatebranch" component={UpdateBranch} />
            <Route path="/updatelocaladmin" component={UpdateLocalAdmin} />
            <Route path="/updatemembers" component={UpdateMember} />
            <Route path="/updatetrainer" component={UpdateTrainer} />

            <Route path="/trainers" component={Trainers} />
            <Route path="/branches" component={BranchesList} />
            <Route path="/packages" component={PackagesList} />
            <Route path="/batches" component={Batches} />
            <Route path="/mybranchpage" component={MyBranchPage} />

            {/* <Route component={ErrorPage} /> */}
            <Route path="/profilelocal" component={ProfileLocal} />
            <Route path="/profilemember" component={ProfileMember} />
          </Switch>
          </Router>
        </Suspense>
      </ReviewContextProvider>
    </TrainerContextProvider>
  );
}

export default App;
