
<template>
  <!--ref完成映射，使subForm方法可以校验-->
  <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
<!--model用于绑定数据；
    rules绑定校验规则：required（true/false）:必填/不必；
                    message:提示信息；
                    trigger：触发事件（blur-失去焦点）-->
    <el-form-item label="课程名称" prop="name">
      <el-input type="textarea" v-model="ruleForm.name"></el-input>
    </el-form-item>
    <el-form-item label="课程性质" prop="property">
      <el-input type="textarea" v-model="ruleForm.property"></el-input>
    </el-form-item>
    <el-form-item label="课本" prop="textbook">
      <el-input type="textarea" v-model="ruleForm.textbook"></el-input>
    </el-form-item>
    <el-form-item label="出版社" prop="publish">
      <el-input type="textarea" v-model="ruleForm.publish"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        name: '',
        property: '',
        textbook: '',
        publish: ''
      },
      rules: {
        name: [
          { required: true, message: '课程名称不能为空', trigger: 'blur' },
        ],
        property: [
          { required: true, message: '课程性质不能为空', trigger: 'blur' }
        ],
        textbook: [
          { required: true, message: '课本不能为空', trigger: 'blur' }
        ],
        publish: [
          { required: true, message: '出版社不能为空', trigger: 'blur'}
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      const _this = this
      //判断当前表单的选项已经全部通过校验
      this.$refs[formName].validate((valid) => {
        if (valid) {
          axios.post('http://localhost:8181/course/save',this.ruleForm).then(function (resp) {
           if(resp.data=='success'){
             _this.$alert('课程 '+_this.ruleForm.name+ ' 添加成功', '消息',{
               confirmButtonText: '确定',
               callback: action => {
                 _this.$router.push('/CourseManage')
               }
             });
           }
          })
          }else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style>

</style>
