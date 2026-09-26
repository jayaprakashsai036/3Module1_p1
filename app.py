from flask import Flask, jsonify, request
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

@app.route("/", methods=["GET"])
def home():
    return jsonify({
        "status": "success",
        "message": "Python backend is running"
    })

@app.route("/api/data", methods=["GET"])
def get_data():
    return jsonify({
        "status": "success",
        "message": "Hello from Python backend",
        "language": "Python"
    })

@app.route("/api/data", methods=["POST"])
def post_data():
    data = request.get_json()

    return jsonify({
        "status": "success",
        "received": data
    })

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)
