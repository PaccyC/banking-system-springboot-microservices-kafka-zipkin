import { Link } from "react-router-dom"


const onSubmit =()=>{

}
const ForgotPassword = () => {

  return (
    <div className=" flex flex-col gap-12 py-16 justify-center ">
        <img 
        src="/images/logo.png" 
        alt="logo"/>

        <div className=" flex flex-col gap-2 items-center">
            <h3 className="text-2xl font-inter font-semibold leading-9 text-dark-1">Forgot Password?</h3>
            <p className=" text-center text-gray-2 text-2xl leading-8 font-inter font-normal">Enter your email address to get the <br/> password reset link</p>
        </div>

        <form onSubmit={onSubmit}>
            <div className="flex flex-col gap-8">
                <div className="flex flex-col gap-2">
                <label className=" font-medium font-inter text-dark-4 text-[16px]">Email</label>
                <input 
                    type="email" 
                    name="email"
                    placeholder="hello@gmail.com"
                    className="border-2 border-dark-3 rounded-lg bg-secondary focus:border-dark-3 w-full px-3 py-3  text-gray-2"
                    />



                </div>
                <button className=" font-semibold text-[16px] leading-6 font-inter bg-primary-1 rounded-lg text-white px-3 py-3">Password Reset</button>
                <Link 
                 className=" font-inter font-semibold text-gray-1 text-[16px] text-center"
                 to="/auth/login">
                Back to login
                </Link>

        </div>
        </form>
    </div>
  )
}

export default ForgotPassword