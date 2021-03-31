<template>
  <div>
    <el-table
        :data="tableData"
        border
        style="width: 60%">
      <el-table-column
          fixed
          prop="num"
          label="序号"
          width="100">
      </el-table-column>
      <el-table-column
          prop="name"
          label="课程名称"
          width="120">
      </el-table-column>
      <el-table-column
          prop="property"
          label="课程性质"
          width="120">
      </el-table-column>
      <el-table-column
          prop="textbook"
          label="课本"
          width="120">
      </el-table-column>
      <el-table-column
          prop="publish"
          label="出版社"
          width="120">
      </el-table-column>
      <el-table-column
          fixed="right"
          label="操作"
          width="100">
        <template #default="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="deleteCourse(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        background
        layout="prev, pager, next"
        page-size="pageSize"
        :total="total"
        @current-change="page">
    </el-pagination>

  </div>


</template>

<script>
export default {
  methods: {
    deleteCourse(row) {
      const _this = this
      axios.delete('http://localhost:8181/course/deleteById/' + row.num).then(function (resp) {
        _this.$alert('课程 ' + row.name + ' 删除成功！', '消息', {
          confirmButtonText: '确定',
          callback: action => {
            // _this.$router.push('/CourseManage')
            window.location.reload()
          }
        });
      })
    },
    edit(row) {
      this.$router.push({
        path: '/update',
        query: {
          num: row.num
        }
      })

    },
    page(currentPage) {
      const _this = this
      axios.get('http://localhost:8181/course/findAll/' + (currentPage - 1) + '/6').then(function (resp) {
        _this.tableData = resp.data.content
        _this.total = resp.data.totalElements
      })
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8181/course/findAll/1/7').then(function (resp) {
      _this.tableData = resp.data.content
      _this.total = resp.data.totalElements
    })
  },

  data() {
    return {
      total: null,
      tableData: null
    }
  }
}
</script>

<style>

</style>
