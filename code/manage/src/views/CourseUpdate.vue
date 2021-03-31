<template>
  <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
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
      <el-button type="primary" @click="submitForm('ruleForm')">确认</el-button>
      <el-button @click="resetForm('ruleForm')">取消</el-button>
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
          axios.post('http://localhost:8181/course/update',this.ruleForm).then(function (resp) {
            if(resp.data=='success'){
              _this.$alert('课程 '+_this.ruleForm.name+ ' 修改成功！', '消息',{
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
  },
  created() {
      const _this=this
      axios.get('http://localhost:8181/course/findById/'+this.$route.query.num).then(function (resp){
      _this.ruleForm= resp.data
    })
  }
}
</script>


<style scoped>

</style>