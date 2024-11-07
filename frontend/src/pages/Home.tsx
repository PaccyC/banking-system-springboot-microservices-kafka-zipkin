import { Link } from "react-router-dom";

const Home = () => {
    return (
      <div className="w-full h-screen flex items-center justify-center bg-secondary">
        <div className=" flex space-y-12 justify-center flex-col">

          <div className=" flex flex-col gap-3">
            <p className="text-center font-inter font-normal text-3xl">Welcome to the </p>
            <h1 className="text-dark-1 text-5xl font-semibold font-inter">Finebank - Financial Management Dashboard</h1>

            <p className="text-center text-gray-1 text-[24px] font-inter font-normal leading-9">This file is totally free for personal project & education purpose, for
              <br/>
              commercial license please contact us</p>
          </div>

          <div className=" w-full flex justify-center">
            <hr className="w-[200px] h-[2px] opacity-30 bg-gray-1  justify-center"/>
          </div>
          <div className=" w-full flex flex-col items-center gap-3">
            <div className="flex flex-col items-center gap-2">
              <p className="text-dark-2 text-center font-inter text-4xl">To download complete dashboard click below button.</p>
              <p className=" font-inter text-3xl leading-[48px]">Don't worry, its <span className="font-bold ">totally free</span></p>
            </div>
            {/* Link */}
            <Link to="/dashboard">
             <button className=" text-2xl py-3 px-12 text-white bg-primary-1 underline rounded-3xl">Finebank Dashboard</button>
            </Link>
          </div>
        </div>
      </div>
    );
  }
  
  export default Home;
  