import React from "react";
import { Link } from "react-router-dom";
import Button from "../components/ui/Button";
import { FcGoogle } from "react-icons/fc";
import { FaGithub } from "react-icons/fa";
import Input from "../components/ui/Input";

const Signup = () => {
  return (
    <div className="min-h-screen flex flex-col justify-center items-center bg-gradient-to-br from-purple-400 via-pink-500 to-grange-400">
      <div className="bg-yellow-100 max-w-[420px] space-x-6">
        <div className="bg-white/95 backdrop-blur-sm rounded-3xl shadow-2xl px-12 py-14">
          <h1 className="text-center mb-6">
            <span className="text-5xl bg-gradient-to-r from-purple-600 via-pink-600 to-orange-500 bg-clip-text text-transparent">
              Instagram
            </span>
          </h1>

          <p className="text-center text-gray-600 font-medium mb-10">
            친구들의 사진과 동영상을 보려면 가입하세요.
          </p>

          <div className="space-y-4 mb-8">
            <Button variant="secondary" icon={<FcGoogle className="w-6 h-6" />}>
              Google로 로그인
            </Button>

            <Button variant="secondary" icon={<FaGithub className="w-6 h-6" />}>
              Github로 로그인
            </Button>
          </div>

          <div className="flex items-center mb-8">
            <div className="flex-1 h-px bg-gradient-to-r from-transparent via-gray-300 to-transparent"></div>
            <span className="px-4 text-gray-600 text-sm font-medium">또는</span>
            <div className="flex-1 h-px bg-gradient-to-r from-transparent via-gray-300 to-transparent"></div>
          </div>

          <form className="space-y-4">
            <Input
              type="email"
              name="email"
              placeholder="Email Address"
              required
            />
            <Input name="fullName" placeholder="Full Name" required />
            <Input name="username" placeholder="User Name" required />
            <Input
              type="password"
              name="password"
              placeholder="Password"
              required
            />
            <p>
              저희 서비스를 이용하는 사람이 회원님의 연락처 정보를 Instagram에
              업로드했을 수도 있습니다. <a>더 알아보기</a>
            </p>

            {/* <p>
              By signing up, you agree to our <a>Terms</a>,{" "}
              <a>Privacy Policy</a> and <a>Cookie Policy</a>.{" "}
            </p> */}

            <button>가입</button>
          </form>

          <p>error</p>
        </div>

        <div>
          <p>
            계정이 있으신가요? <Link to="/login">로그인</Link>
          </p>
        </div>

        <div>
          <p>Get the app.</p>
          <div>
            <img
              src="https://static.cdninstagram.com/rsrc.php/v3/yz/r/c5Rp7Ym-Klz.png"
              alt="Get it on Google Play"
              className="h-12 hover:scale-105 transition-transform cursor-pointer"
            />
            <img
              src="https://static.cdninstagram.com/rsrc.php/v3/yu/r/EHY6QnZYdNX.png"
              alt="Get it from Microsoft"
              className="h-12 hover:scale-105 transition-transform cursor-pointer"
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Signup;
