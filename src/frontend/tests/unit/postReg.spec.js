import PostsReg from '@/components/posts/PostsReg'
import {mount} from "@vue/test-utils";
import sinon from 'sinon';

it('등록 버튼 클릭 시, regPosts() 메서드 호출 확인', async ()=>{
    const spy = sinon.spy()
    const wrapper = mount(PostsReg, {
        propsData:{
            post:spy
        }
    })
    await wrapper.find('button').trigger('click')

    spy.should.have.been.calledWith('test')
})